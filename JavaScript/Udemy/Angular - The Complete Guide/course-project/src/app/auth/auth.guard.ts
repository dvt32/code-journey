import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Store } from "@ngrx/store";
import { Observable } from "rxjs";
import { map, take, tap } from "rxjs/operators";
import { AuthService } from "./auth.service";
import * as fromApp from "../store/app.reducer";

@Injectable({providedIn: "root"})
export class AuthGuard implements CanActivate {

    constructor(
        private authService: AuthService, 
        private router: Router,
        private store: Store<fromApp.AppState>
    ) {}

    canActivate(
        route: ActivatedRouteSnapshot, 
        state: RouterStateSnapshot
    ): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
        return this.store.select("auth")
            .pipe(
                take(1), // take latest user value and unsubscribe for this guard execution
                map(authState => {
                    return authState.user;
                }),
                map(user => {
                    const isAuth = !!user;
                    if (isAuth) {
                        return true;
                    }
                    else {
                        return this.router.createUrlTree(["/auth"]);
                    }
                })
                /*
                tap(isAuth => {
                    if (!isAuth) {
                        this.router.navigate(["/auth"]);
                    }
                })
                */
            );
    }

}