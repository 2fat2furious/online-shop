import { Component, Input } from '@angular/core';
import {ProductsService} from '../products.service';

@Component({
    selector: 'app-product',
    templateUrl: './product.component.html'
})
export class ProductComponent {
    @Input() product: any;

    products = [];
  constructor(private productsService: ProductsService){}

  ngOnInit(){
   
   this.productsService.getProducts().subscribe((products: Array<any>)=> {
     this.products=products
   });
  }
}