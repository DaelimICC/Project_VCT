import Tabbar from './Tabbar';
import Header from './header';
import Nav from './nav';

const Layout = ({ children }) => {
  return (
    <div className="flex justify-center min-h-screen h-max bg-zinc-50 pt-[104px] pb-[65px]">
      <div className="max-w-[500px] w-[500px] bg-white">
        <Header />
        <Nav />
        {children}
        <Tabbar />
      </div>
    </div>
  );
};

export default Layout;
