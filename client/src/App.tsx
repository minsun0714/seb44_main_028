import React from 'react';
import { Provider } from 'react-redux';
import { QueryClient, QueryClientProvider } from 'react-query';
import Router from './Router';
import Header from './pages/Header/views/Header';
import Footer from './pages/Footer/views/Footer';
import Container from '@mui/material/Container';
import { store } from './common/store/RootStore';
import ItemCard from './common/components/ItemCard';

function App() {
  const queryClient = new QueryClient();
  return (
    <QueryClientProvider client={queryClient}>
      <Header />
      <Container maxWidth="xs">
        {/* <ItemCard /> */}
        <Provider store={store}>
          <Router />
        </Provider>
<<<<<<< HEAD
        <Footer prop1={'로고'} />
=======
>>>>>>> f88a054e74e033ab128d0b64a10930f588002671
      </Container>
      <Footer prop1={'로고'} />
    </QueryClientProvider>
  );
}

export default App;
