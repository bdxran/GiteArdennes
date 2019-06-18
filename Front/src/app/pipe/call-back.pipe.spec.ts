import { CallBackPipe } from './call-back.pipe';

describe('CallBackPipe', () => {
  it('create an instance', () => {
    const pipe = new CallBackPipe();
    expect(pipe).toBeTruthy();
  });
});
