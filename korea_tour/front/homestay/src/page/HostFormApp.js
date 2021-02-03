import React from 'react';
import HostForm from 'components/HostForm';
import { HostProvider } from 'HostContext';

export default function HostFormApp() {
  return (
    <HostProvider>
      <HostForm />
    </HostProvider>
  );
}
