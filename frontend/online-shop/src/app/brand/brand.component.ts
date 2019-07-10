import { Component, Input } from '@angular/core';
import {BrandsService} from '../brands.service';

@Component({
    selector: 'app-brand',
    templateUrl: './brand.component.html'
})
export class BrandComponent {
    @Input() brand: any;

   brands = [];
  constructor(private brandsService: BrandsService){}

  ngOnInit(){
   
   this.brandsService.getTypes().subscribe((brands: Array<any>)=> {
     this.brands=brands
   });
  }
}