import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Product } from './product.class';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

    private static productslist: Product[] = null;
    private products$: BehaviorSubject<Product[]> = new BehaviorSubject<Product[]>([]);
    private headers = new HttpHeaders();
    private backEndPort = 8080;

    constructor(private http: HttpClient) { }

    getProducts(): Observable<Product[]> {
        if( ! ProductsService.productslist )
        {
            return this.http.get<any>('http://localhost:'+this.backEndPort+'/products');
            // this.http.get<any>('assets/products.json').subscribe(data => {
            //     ProductsService.productslist = data.data;
                
            //     this.products$.next(ProductsService.productslist);
            // });
        }
        else
        {
            this.products$.next(ProductsService.productslist);
        }

        return this.products$;
    }

    create(prod: Product): Observable<Product[]> {

        // ProductsService.productslist.push(prod);
        // this.products$.next(ProductsService.productslist);
        
        // return this.products$;
        this.headers.append('content-type', 'application/json');
        return this.http.post<any>('http://localhost:'+this.backEndPort+'/products', prod , {headers: this.headers});
    }

    update(prod: Product): Observable<Product[]>{
        // ProductsService.productslist.forEach(element => {
        //     if(element.id == prod.id)
        //     {
        //         element.name = prod.name;
        //         element.category = prod.category;
        //         element.code = prod.code;
        //         element.description = prod.description;
        //         element.image = prod.image;
        //         element.inventoryStatus = prod.inventoryStatus;
        //         element.price = prod.price;
        //         element.quantity = prod.quantity;
        //         element.rating = prod.rating;
        //     }
        // });
        // this.products$.next(ProductsService.productslist);

        // return this.products$;

        this.headers.append('content-type', 'application/json');
        return this.http.patch<any>('http://localhost:'+this.backEndPort+'/products/'+prod.id, prod , {headers: this.headers});
    }


    delete(id: number): Observable<Product[]>{
        // ProductsService.productslist = ProductsService.productslist.filter(value => { return value.id !== id } );
        // this.products$.next(ProductsService.productslist);
        // return this.products$;
        return this.http.delete<any>('http://localhost:'+this.backEndPort+'/products/'+id );
    }
}