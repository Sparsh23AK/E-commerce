import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardscompComponent } from './cardscomp.component';

describe('CardscompComponent', () => {
  let component: CardscompComponent;
  let fixture: ComponentFixture<CardscompComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardscompComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardscompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
