import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplyLoanComponent } from './apply-loan.component';

describe('ApplyLoanComponent', () => {
  let component: ApplyLoanComponent;
  let fixture: ComponentFixture<ApplyLoanComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApplyLoanComponent]
    });
    fixture = TestBed.createComponent(ApplyLoanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
