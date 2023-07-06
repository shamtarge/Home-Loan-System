import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplyLoanAdminComponent } from './apply-loan-admin.component';

describe('ApplyLoanAdminComponent', () => {
  let component: ApplyLoanAdminComponent;
  let fixture: ComponentFixture<ApplyLoanAdminComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApplyLoanAdminComponent]
    });
    fixture = TestBed.createComponent(ApplyLoanAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
