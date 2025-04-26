import { Box, Container } from '@chakra-ui/react';
import { AuthForm } from '../components/AuthForm';

export const RegisterPage = () => {
  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    // TODO: Implement registration logic
    console.log('Register form submitted');
  };

  return (
    <Container maxW="container.sm">
      <Box py={8}>
        <AuthForm type="register" onSubmit={handleSubmit} />
      </Box>
    </Container>
  );
}; 