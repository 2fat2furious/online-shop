import { Component } from '@angular/core';
import { ProductsService } from '../products.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { mergeMap } from 'rxjs/operators'
import { BrandsService } from '../brands.service';
import { TypesService } from '../types.service';

@Component({
    selector: 'app-form',
    templateUrl: './update.component.html',
    styleUrls: ['./update.component.css']
})
export class UpdateComponent {
    private product = {
        name: '',
        price: 100,
        description: '',
        skin_type: '',
        id_brand: 1,
        type_id: 111,
        color: 'white',
        image: ''
    };

    private types = [];
    private brands = [];

    constructor(
        private route: ActivatedRoute,
        private productService: ProductsService,
        private brandsService: BrandsService,
        private typesService: TypesService
    ) { }

    ngOnInit() {
        this.brandsService.getTypes().subscribe((response: Array<any>) => this.brands = response);
        this.typesService.getTypes().subscribe((response: Array<any>) => this.types = response);
        this.route.paramMap.pipe(
            mergeMap((params: ParamMap) => this.productService.getProductById(params.get('id')))
        ).subscribe((_product: any) => this.product = _product);
    }

    handleInsert() {
        this.productService.insertProduct(this.product).subscribe(() => (window as any).location = "http://localhost:4200/products");
    }
}