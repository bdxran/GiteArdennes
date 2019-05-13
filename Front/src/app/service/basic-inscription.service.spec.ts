import { TestBed } from '@angular/core/testing';

import { BasicInscriptionService } from './basic-inscription.service';

describe('BasicInscriptionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BasicInscriptionService = TestBed.get(BasicInscriptionService);
    expect(service).toBeTruthy();
  });
});
