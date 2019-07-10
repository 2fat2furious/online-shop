import { Component, Input } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap, tap } from 'rxjs/operators'
import { ProductsService } from '../products.service';

@Component({
    selector: 'app-item',
    templateUrl: './item.component.html',
    styleUrls: ['./item.component.css']
})
export class ItemComponent {
    private product: any;
    
    constructor(
        private route: ActivatedRoute,
        private productService: ProductsService
    ) { }

    ngOnInit() {
        this.route.paramMap.pipe(
            switchMap((params: ParamMap) => {
                console.log('ID', params.get('id'))
                return this.productService.getProductById(params.get('id'));
            }),
            tap(console.log)
        ).subscribe(_product => this.product = _product);
    }

    handleDelete() {
        this.productService.deleteProduct(this.product.id).subscribe(() => (window as any).location = "http://localhost:4200/products");
    }


}