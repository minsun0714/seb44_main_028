import { useState } from 'react';
import { BrowserRouter as Router, Link, useNavigate } from 'react-router-dom';
import { MdSearch, MdSend, MdLogout, MdError } from 'react-icons/md';
import { LogoText, NavMenuList } from '../constants';
import {
  HeaderContainer,
  LogoWrapper,
  NavWrapper,
  NavList,
  NavIconWrapper,
  NavSendIconWrapper,
  NavSearchForm,
  ActionWrapper,
  LogoutInfo,
} from '../style';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '../../../common/store/RootStore';
import { deleteUserInfo } from '../../../common/store/UserInfoStore';

function Header() {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const [isClick, setIsClick] = useState(false);
  const [isLogoutHovered, setIsLogoutHovered] = useState(false);
  const isLoggedIn = useSelector((state: RootState) => state.userInfo);
  const handleClick = () => {
    setIsClick(!isClick);
  };

  const handleLoginStatus = async () => {
    if (isLoggedIn) {
      dispatch(deleteUserInfo());
      //TODO: "로그아웃 되었습니다."모달창 띄워주기
    }
    navigate('/login');
  };

  return (
    <HeaderContainer>
      <LogoWrapper>
        <Link to="/">{LogoText}</Link>
      </LogoWrapper>
      <NavWrapper>
        <ol>
          {NavMenuList.map((NavMenu, index) => (
            <NavList key={index}>
              <Link to={NavMenu.href}>{NavMenu.title}</Link>
            </NavList>
          ))}
        </ol>
        <NavIconWrapper>
          <NavSearchForm isClick={isClick}>
            <input type="text" />
            <MdSearch onClick={handleClick} />
          </NavSearchForm>
          <NavSendIconWrapper>
            <Link to="/chatting">
              <MdSend />
            </Link>
          </NavSendIconWrapper>
        </NavIconWrapper>
      </NavWrapper>
      <ActionWrapper onClick={handleLoginStatus}>
        <MdLogout
          onMouseEnter={() => setIsLogoutHovered(true)}
          onMouseLeave={() => setIsLogoutHovered(false)}
        />
        <LogoutInfo isHovered={isLogoutHovered}>logout</LogoutInfo>
      </ActionWrapper>
    </HeaderContainer>
  );
}
export default Header;
