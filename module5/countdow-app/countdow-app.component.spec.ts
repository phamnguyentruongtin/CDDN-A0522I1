import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CountdowAppComponent } from './countdow-app.component';

describe('CountdowAppComponent', () => {
  let component: CountdowAppComponent;
  let fixture: ComponentFixture<CountdowAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CountdowAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CountdowAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
