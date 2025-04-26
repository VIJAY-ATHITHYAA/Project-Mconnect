import {
  Box,
  Button,
  FormControl,
  FormLabel,
  Input,
  VStack,
  Text,
  Link,
} from '@chakra-ui/react';
import { Link as RouterLink } from 'react-router-dom';

interface AuthFormProps {
  type: 'login' | 'register';
  onSubmit: (e: React.FormEvent) => void;
}

export const AuthForm = ({ type, onSubmit }: AuthFormProps) => {
  return (
    <Box
      maxW="md"
      mx="auto"
      mt={8}
      p={6}
      borderWidth="1px"
      borderRadius="lg"
      boxShadow="lg"
      bg="white"
    >
      <form onSubmit={onSubmit}>
        <VStack spacing={4}>
          <Heading as="h1" size="xl" color="brand.primary">
            {type === 'login' ? 'Welcome Back' : 'Create Account'}
          </Heading>
          
          {type === 'register' && (
            <FormControl isRequired>
              <FormLabel>Full Name</FormLabel>
              <Input type="text" name="name" />
            </FormControl>
          )}

          <FormControl isRequired>
            <FormLabel>Email</FormLabel>
            <Input type="email" name="email" />
          </FormControl>

          <FormControl isRequired>
            <FormLabel>Password</FormLabel>
            <Input type="password" name="password" />
          </FormControl>

          {type === 'register' && (
            <FormControl isRequired>
              <FormLabel>Confirm Password</FormLabel>
              <Input type="password" name="confirmPassword" />
            </FormControl>
          )}

          <Button
            type="submit"
            colorScheme="blue"
            size="lg"
            width="full"
            mt={4}
          >
            {type === 'login' ? 'Login' : 'Register'}
          </Button>

          <Text>
            {type === 'login' ? (
              <>
                Don't have an account?{' '}
                <Link as={RouterLink} to="/register" color="blue.500">
                  Register
                </Link>
              </>
            ) : (
              <>
                Already have an account?{' '}
                <Link as={RouterLink} to="/login" color="blue.500">
                  Login
                </Link>
              </>
            )}
          </Text>
        </VStack>
      </form>
    </Box>
  );
}; 