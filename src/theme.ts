import { extendTheme } from '@chakra-ui/react';

export const theme = extendTheme({
  colors: {
    brand: {
      primary: '#2D3748',
      secondary: '#4A5568',
      accent: '#4299E1',
      background: '#F7FAFC',
    },
  },
  fonts: {
    heading: 'Inter, sans-serif',
    body: 'Inter, sans-serif',
  },
  styles: {
    global: {
      body: {
        bg: 'brand.background',
        color: 'brand.primary',
      },
    },
  },
  components: {
    Button: {
      baseStyle: {
        fontWeight: 'semibold',
        borderRadius: 'md',
      },
      variants: {
        solid: {
          bg: 'brand.accent',
          color: 'white',
          _hover: {
            bg: 'blue.600',
          },
        },
        outline: {
          borderColor: 'brand.accent',
          color: 'brand.accent',
          _hover: {
            bg: 'blue.50',
          },
        },
      },
    },
  },
}); 