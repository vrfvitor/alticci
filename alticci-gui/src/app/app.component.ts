import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AlticciService } from "./services/alticci.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  valueForm!: FormGroup
  result = 0
  lastCalculated = 0

  constructor(private alticciService: AlticciService) {
  }

  ngOnInit() {
    this.initForm()
  }

  onSubmit() {
    if (this.valueForm.valid) {
      const valueInput = this.valueForm.value
      this.lastCalculated = valueInput.value
      this.alticciService.getResultFor(this.lastCalculated)
        .subscribe(r => this.result = r)
    }
  }

  private initForm() {
    this.valueForm = new FormGroup({
      value: new FormControl(0, [Validators.required, Validators.min(0)])
    });
  }
}
