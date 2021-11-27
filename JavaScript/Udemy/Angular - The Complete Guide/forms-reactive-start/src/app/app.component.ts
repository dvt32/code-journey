import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { CustomValidators } from './custom-validators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  genders = ['male', 'female'];
  signupForm: FormGroup;
  forbiddenUsernames = ['Chris', 'Anna'];
  projectForm: FormGroup;

  ngOnInit(): void {
    this.signupForm = new FormGroup({
      "userData": new FormGroup({
        "username": new FormControl(null, [Validators.required, this.forbiddenNames.bind(this)] /* do not CALL method, but pass REFERENCE to it */),
        "email": new FormControl(null, [Validators.required, Validators.email], this.forbiddenEmails),
      }),
      "gender": new FormControl("male"),
      "hobbies": new FormArray([])
    });

    /*
    this.signupForm.valueChanges.subscribe(
      (value) => {
        console.log(value);
      }
    );
    */

    this.signupForm.statusChanges.subscribe(
      (status) => console.log(status)
    );

    this.signupForm.patchValue(
      {
        'userData': {
          'username': 'Anna'
        }
      }
    );

    // Assignment form
    this.projectForm = new FormGroup({
      'projectName': new FormControl(
        null, [Validators.required, CustomValidators.invalidProjectName], CustomValidators.asyncInvalidProjectName
      ),
      'email': new FormControl(null, [Validators.required, Validators.email]),
      'projectStatus': new FormControl('critical')
    });
  }

  onSubmit() {
    console.log(this.signupForm);
    this.signupForm.reset();
  }

  onAddHobby() {
    const control = new FormControl(null, Validators.required);
    (<FormArray> this.signupForm.get("hobbies")).push(control);
  }

  getControls() {
    return (<FormArray> this.signupForm.get('hobbies')).controls;
  }

  forbiddenNames(control: FormControl): {[s: string]: boolean} {
    if (this.forbiddenUsernames.indexOf(control.value) !== -1) {
      return {'nameIsForbidden': true};
    }
    else {
      return null;
    }
  }

  forbiddenEmails(control: FormControl): Promise<any> | Observable<any> {
    const promise = new Promise<any>(
      (resolve, reject) => {
        setTimeout(
          () => {
            if (control.value === 'test@test.com') {
              resolve( {'emailIsForbidden': true} );
            }
            else {
              resolve(null);
            }
          }, 
          1500
        );
      }
    );

    return promise;
  }

  // Assignment submit method
  onSaveProject() {
    console.log(this.projectForm.value);
  }

}
