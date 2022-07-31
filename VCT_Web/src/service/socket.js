import { createContext } from 'react';
import { io } from 'socket.io-client';

export const socket = io('ws://158.247.200.77:8081/ws');
export const SockteContext = createContext(socket);

socket.on('connect', () => {
  console.log('socket server connected');
});

socket.on('disconnect', () => {
  console.log('socket server disconnected');
});

export const SOCKET_EVENT = {
  ACCESS_PAGE: 'ACCESS_PAGE',
  UPDATE_COIN: 'UPDATE_COIN',
};
