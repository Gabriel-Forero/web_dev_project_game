import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarEstrellaComponent } from './agregar-estrella.component';

describe('AgregarEstrellaComponent', () => {
  let component: AgregarEstrellaComponent;
  let fixture: ComponentFixture<AgregarEstrellaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgregarEstrellaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AgregarEstrellaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
