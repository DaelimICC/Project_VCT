from django.urls import path
from rest_framework_simplejwt.views import TokenObtainPairView, TokenRefreshView, TokenVerifyView
from vct_auth.views.login import LoginView
from vct_auth.views.logout import LogOutView
from vct_auth.views.signUp import SignUpView

app_name = 'vct_auth'

urlpatterns = [
    path('token/', TokenObtainPairView.as_view()),
    path('token/verify/', TokenVerifyView.as_view()),
    path('token/refresh/', TokenRefreshView.as_view()),
    path('signup/', SignUpView.as_view()),
    path('login/', LoginView.as_view()),
    path('logout/', LogOutView.as_view()),
]
