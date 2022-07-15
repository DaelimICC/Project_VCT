import Tabbar from './Tabbar';
import Header from './header';

const Layout = ({ children }) => {
  return (
    <div className="flex justify-center min-h-screen h-max bg-zinc-50 pt-[104px] pb-[65px]">
      <div className="max-w-[500px] w-[500px]">
        <Header />
        {children}
        <Tabbar />
      </div>
    </div>
  );
};

export default Layout;
