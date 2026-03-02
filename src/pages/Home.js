import React from 'react';
import { Box, Typography, Button, Grid, Card, CardContent } from '@mui/material';
import LocalShippingIcon from '@mui/icons-material/LocalShipping';
import DiscountIcon from '@mui/icons-material/Discount';
import SupportAgentIcon from '@mui/icons-material/SupportAgent';
import InventoryIcon from '@mui/icons-material/Inventory';
import { useNavigate } from 'react-router-dom';
function Home() {
  const navigate = useNavigate();
  const features = [
    { icon: <InventoryIcon fontSize="large" color="primary" />, title: 'Wide Product Range', desc: 'Browse hundreds of wholesale grocery products at best prices' },
    { icon: <DiscountIcon fontSize="large" color="primary" />, title: 'Special Pricing', desc: 'Get exclusive prices based on your purchase category' },
    { icon: <LocalShippingIcon fontSize="large" color="primary" />, title: 'Fast Delivery', desc: 'Quick and reliable delivery to your doorstep' },
    { icon: <SupportAgentIcon fontSize="large" color="primary" />, title: '24/7 Support', desc: 'Our team is always ready to help you anytime' }
  ];
  return (
    <Box>
      <Box sx={{ background: 'linear-gradient(135deg, #2e7d32 0%, #66bb6a 100%)', color: 'white', py: 10, px: 4, textAlign: 'center' }}>
        <Typography variant="h3" fontWeight={700} gutterBottom>
          Welcome to FreshWholesale 🛒
        </Typography>
        <Typography variant="h6" sx={{ mb: 4, opacity: 0.9 }}>
          Your trusted wholesale grocery partner — best prices, best quality!
        </Typography>
        <Box sx={{ display: 'flex', gap: 2, justifyContent: 'center' }}>
          <Button variant="contained" size="large" color="secondary" onClick={() => navigate('/products')} sx={{ fontWeight: 700, borderRadius: 3 }}>
            Shop Now
          </Button>
          <Button variant="outlined" size="large" sx={{ color: 'white', borderColor: 'white', borderRadius: 3 }} onClick={() => navigate('/owner')}>
            Owner Dashboard
          </Button>
        </Box>
      </Box>
      <Box sx={{ py: 8, px: 4 }}>
        <Typography variant="h4" fontWeight={700} textAlign="center" gutterBottom>
          Why Choose Us?
        </Typography>
        <Typography variant="body1" textAlign="center" color="text.secondary" sx={{ mb: 6 }}>
          We provide the best wholesale grocery experience
        </Typography>
        <Grid container spacing={4} justifyContent="center">
          {features.map((feature, index) => (
            <Grid item xs={12} sm={6} md={3} key={index}>
              <Card elevation={3} sx={{ textAlign: 'center', p: 2, borderRadius: 3, height: '100%', '&:hover': { transform: 'translateY(-5px)', transition: '0.3s' } }}>
                <CardContent>
                  <Box sx={{ mb: 2 }}>{feature.icon}</Box>
                  <Typography variant="h6" fontWeight={600} gutterBottom>{feature.title}</Typography>
                  <Typography variant="body2" color="text.secondary">{feature.desc}</Typography>
                </CardContent>
              </Card>
            </Grid>
          ))}
        </Grid>
      </Box>
      <Box sx={{ background: '#2e7d32', color: 'white', py: 6, textAlign: 'center' }}>
        <Typography variant="h4" fontWeight={700} gutterBottom>Ready to Order?</Typography>
        <Typography variant="body1" sx={{ mb: 3, opacity: 0.9 }}>Join thousands of happy customers today!</Typography>
        <Button variant="contained" color="secondary" size="large" onClick={() => navigate('/products')} sx={{ borderRadius: 3, fontWeight: 700 }}>
          Browse Products
        </Button>
      </Box>
    </Box>
  );
}
export default Home;