import { Box, Container } from '@chakra-ui/react';
import { AuthForm } from '../components/AuthForm';

export const LoginPage = () => {
  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    // TODO: Implement login logic
    console.log('Login form submitted');
  };

  return (
    <Container maxW="container.sm">
      <Box py={8}>
        <AuthForm type="login" onSubmit={handleSubmit} />
      </Box>
    </Container>
  );
}; 