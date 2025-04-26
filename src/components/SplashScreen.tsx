import { Box, Button, Center, Heading, VStack } from '@chakra-ui/react';
import { motion } from 'framer-motion';
import { useNavigate } from 'react-router-dom';

const MotionBox = motion(Box);

export const SplashScreen = () => {
  const navigate = useNavigate();

  return (
    <Center h="100vh" bg="brand.background">
      <VStack spacing={8}>
        <MotionBox
          initial={{ scale: 0, opacity: 0 }}
          animate={{ scale: 1, opacity: 1 }}
          transition={{ duration: 0.8, ease: 'easeOut' }}
        >
          <Heading
            fontSize="4xl"
            color="brand.primary"
            textAlign="center"
            mb={4}
          >
            MConnect
          </Heading>
          <Heading
            fontSize="xl"
            color="brand.secondary"
            textAlign="center"
            fontWeight="normal"
          >
            MIT Student Marketplace
          </Heading>
        </MotionBox>

        <MotionBox
          initial={{ y: 50, opacity: 0 }}
          animate={{ y: 0, opacity: 1 }}
          transition={{ delay: 0.5, duration: 0.8 }}
        >
          <VStack spacing={4}>
            <Button
              size="lg"
              width="200px"
              onClick={() => navigate('/login')}
            >
              Login
            </Button>
            <Button
              size="lg"
              width="200px"
              variant="outline"
              onClick={() => navigate('/register')}
            >
              Register
            </Button>
          </VStack>
        </MotionBox>
      </VStack>
    </Center>
  );
}; 