import { TestBed } from '@angular/core/testing';

import { BasicAuthentificateService } from './basic-authentificate.service';

describe('BasicAuthentificateService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BasicAuthentificateService = TestBed.get(BasicAuthentificateService);
    expect(service).toBeTruthy();
  });
});
