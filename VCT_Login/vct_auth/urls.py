from django.urls import path
from rest_framework_simplejwt.views import TokenObtainPairView, TokenRefreshView, TokenVerifyView

urlpatterns = [
    path('token/', TokenObtainPairView.as_view()),
    path('token/verify/', TokenRefreshView.as_view()),
    path('token/refresh/', TokenVerifyView.as_view()),
]
