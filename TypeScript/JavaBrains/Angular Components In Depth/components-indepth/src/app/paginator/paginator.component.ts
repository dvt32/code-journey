import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-paginator',
  templateUrl: './paginator.component.html',
  styleUrls: ['./paginator.component.scss']
})
export class PaginatorComponent implements OnInit {

  @Input() numberOfPages;
  @Output() pageNumberClick = new EventEmitter<number>();
  pages: number[];

  constructor() { }

  ngOnInit() {
    this.pages = new Array(this.numberOfPages);
  }

  pageNumberClicked(pageNumber) {
    this.pageNumberClick.emit(pageNumber);
  }

}
