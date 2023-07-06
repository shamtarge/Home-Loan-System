import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeClientPasswordComponent } from './change-client-password.component';

describe('ChangeClientPasswordComponent', () => {
  let component: ChangeClientPasswordComponent;
  let fixture: ComponentFixture<ChangeClientPasswordComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ChangeClientPasswordComponent]
    });
    fixture = TestBed.createComponent(ChangeClientPasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
