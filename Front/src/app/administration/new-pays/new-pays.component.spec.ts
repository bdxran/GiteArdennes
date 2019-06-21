import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewPaysComponent } from './new-pays.component';

describe('NewPaysComponent', () => {
  let component: NewPaysComponent;
  let fixture: ComponentFixture<NewPaysComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewPaysComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewPaysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
