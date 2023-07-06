import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewStatusOfAllComponent } from './view-status-of-all.component';

describe('ViewStatusOfAllComponent', () => {
  let component: ViewStatusOfAllComponent;
  let fixture: ComponentFixture<ViewStatusOfAllComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewStatusOfAllComponent]
    });
    fixture = TestBed.createComponent(ViewStatusOfAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
