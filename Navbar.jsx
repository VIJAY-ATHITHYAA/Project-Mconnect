import React from 'react';
import { AppBar, Toolbar, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';

const Navbar = () => (
  <AppBar position="sticky">
    <Toolbar>
      <Typography variant="h6">MIT Connect</Typography>
      <Button color="inherit" component={Link} to="/">Home</Button>
      <Button color="inherit" component={Link} to="/login">Login</Button>
      <Button color="inherit" component={Link} to="/reviews">Reviews</Button>
    </Toolbar>
  </AppBar>
);

export default Navbar;
