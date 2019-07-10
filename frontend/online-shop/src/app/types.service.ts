import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable()
export class TypesService {

    constructor(private http: HttpClient){}

    getTypes(){
        return this.http.get('http://localhost:8080/types');
        
    }
    types = [

        {name: 'bronzer'},
        {name: 'powder'},
        {name: 'eyeliner'},
        {name: 'eyeshadow'},
        {name: 'glitter'},
        {name: 'lipgloss'},
        {name: 'blush'}
      ]
}