import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable()
export class BrandsService {

    constructor(private http: HttpClient){}

    getTypes(){
        return this.http.get('http://localhost:8080/brands');
        
    }
    
}