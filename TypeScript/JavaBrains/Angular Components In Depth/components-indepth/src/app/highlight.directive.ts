import { Directive, ElementRef, HostListener, Host, Input } from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {

  @Input() color = 'yellow';

  constructor(private element: ElementRef) {
    
  }

  @HostListener('mouseenter') addHighlight() {
    this.element.nativeElement.style.backgroundColor = this.color;
  }

  @HostListener('mouseleave') removeHighlight() {
    this.element.nativeElement.style.backgroundColor = null;
  }

}
