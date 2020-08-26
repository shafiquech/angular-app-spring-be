import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class BikeService {

  constructor(private http: HttpClient) {
  }

  getBikes() {
    return this.http.get('/api/v1/bikes');
  }

  getBike(id: number) {
    return this.http.get('/api/v1/bikes/' + id);
  }

  createBikeRegistration(value: any) {
    return this.http.post('/api/v1/bikes', value);
  }
}
