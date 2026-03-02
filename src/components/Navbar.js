import React, { useState } from 'react';
import { AppBar, Toolbar, Typography, Button, IconButton, Badge, Box } from '@mui/material';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import StorefrontIcon from '@mui/icons-material/Storefront';
import { useNavigate } from 'react-router-dom';
function Navbar() {
  const navigate = useNavigate();
  return (
    <AppBar position="sticky" color="primary" elevation={3}>
      <Toolbar>
        <IconButton color="inherit" onClick={() => navigate('/')}>
          <StorefrontIcon />
        </IconButton>
        <Typography variant="h6" fontWeight={700} sx={{ flexGrow: 1, cursor: 'pointer' }} onClick={() => navigate('/')}>
          FreshWholesale
        </Typography>
        <Box sx={{ display: 'flex', gap: 1 }}>
          <Button color="inherit" onClick={() => navigate('/')}>Home</Button>
          <Button color="inherit" onClick={() => navigate('/products')}>Products</Button>
          <Button color="inherit" onClick={() => navigate('/orders')}>Orders</Button>
          <Button color="inherit" onClick={() => navigate('/owner')}>Owner</Button>
          <IconButton color="inherit" onClick={() => navigate('/cart')}>
            <Badge badgeContent={0} color="secondary">
              <ShoppingCartIcon />
            </Badge>
          </IconButton>
        </Box>
      </Toolbar>
    </AppBar>
  );
}
export default Navbar;