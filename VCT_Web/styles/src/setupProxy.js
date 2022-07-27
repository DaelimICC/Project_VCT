const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function (app) {
  app.use(
    '/api',
    createProxyMiddleware({
      target: 'https://localhost:3000',
      pathRewrite: {
        '^/api': '',
      },
      changeOrigin: true,
    })
  );
};
