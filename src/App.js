import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { ThemeProvider, createTheme } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import Home from './pages/Home';
import Products from './pages/Products';
import Cart from './pages/Cart';
import Orders from './pages/Orders';
import OwnerDashboard from './pages/OwnerDashboard';
import Navbar from './components/Navbar';
const theme = createTheme({
  palette: {
    primary: { main: '#2e7d32' },
    secondary: { main: '#ff6f00' },
    background: { default: '#f5f5f5' }
  },
  typography: {
    fontFamily: '"Poppins", "Roboto", sans-serif'
  }
});
function App() {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/products" element={<Products />} />
          <Route path="/cart" element={<Cart />} />
          <Route path="/orders" element={<Orders />} />
          <Route path="/owner" element={<OwnerDashboard />} />
        </Routes>
      </Router>
    </ThemeProvider>
  );
}
export default App;