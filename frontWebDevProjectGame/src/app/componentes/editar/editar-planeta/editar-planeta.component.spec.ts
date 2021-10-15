import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarPlanetaComponent } from './editar-planeta.component';

describe('EditarPlanetaComponent', () => {
  let component: EditarPlanetaComponent;
  let fixture: ComponentFixture<EditarPlanetaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarPlanetaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarPlanetaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
