from django.urls import path
from vct_auth.views.login import LoginView
from vct_auth.views.logout import LogOutView
from vct_auth.views.UserView import UserView

app_name = 'vct_auth'

urlpatterns = [
    path('user', UserView.as_view()),
    path('login', LoginView.as_view()),
    path('logout', LogOutView.as_view()),
]
