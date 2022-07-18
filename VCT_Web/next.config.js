/** @type {import('next').NextConfig} */
const nextConfig = {
  images: {
    domains: ['search.pstatic.net'],
  },
  reactStrictMode: true,
  swcMinify: true,
};

module.exports = nextConfig;
