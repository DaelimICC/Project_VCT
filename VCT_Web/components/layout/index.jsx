import Footer from './footer';
import Header from './header';
import Nav from './nav';

const Layout = ({ children }) => {
  return (
    <div className="flex justify-center bg-zinc-50">
      <div className="max-w-[500px] w-[500px] h-screen bg-white border border-red-500">
        <Header />
        <Nav />
        {children}
        <Footer />
      </div>
    </div>
  );
};

export default Layout;
