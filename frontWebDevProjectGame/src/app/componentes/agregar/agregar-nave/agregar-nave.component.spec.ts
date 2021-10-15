import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarNaveComponent } from './agregar-nave.component';

describe('AgregarNaveComponent', () => {
  let component: AgregarNaveComponent;
  let fixture: ComponentFixture<AgregarNaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgregarNaveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AgregarNaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
