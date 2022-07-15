import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from "../../environments/environment";
import { map } from "rxjs";

const BASE_URI = environment['API_URL'] + '/alticci'

@Injectable({
  providedIn: 'root'
})
export class AlticciService {

  constructor(private http: HttpClient) {
  }

  getResultFor(n: number) {
    return this.http.get(`${BASE_URI}/${n}`)
    .pipe(map((r: any) => r.result))
  }
}
