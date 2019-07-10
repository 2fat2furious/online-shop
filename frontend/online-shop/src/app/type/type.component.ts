import { Component, Input } from '@angular/core';
import {TypesService} from '../types.service'

@Component({
    selector: 'app-type',
    templateUrl: './type.component.html'
})
export class TypeComponent {
    @Input() type: any;

    types = [];
  constructor(private typesService: TypesService){}

  ngOnInit(){
   // this.types = this.typesService.types;
   this.typesService.getTypes().subscribe((types: Array<any>)=> {
     this.types=types
   });
  }
}