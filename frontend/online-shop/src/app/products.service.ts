import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable()
export class ProductsService {

    constructor(private http: HttpClient) { }

    public getProducts() {
        return this.http.get('http://localhost:8080/products');
    }

    public getProductById(id: string) {
        return this.http.get(`http://localhost:8080/products/${id}`);
    }

    public deleteProduct(id: any) {
        return this.http.delete(`http://localhost:8080/products/${id}`);
    }

    public insertProduct(product: any) {
        return this.http.post(`http://localhost:8080/products`, product);
    }
    
}