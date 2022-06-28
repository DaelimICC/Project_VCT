from django.http import JsonResponse
from rest_framework import status
from rest_framework.views import APIView
from rest_framework.parsers import JSONParser
from django.contrib.auth import authenticate, login
from rest_framework_simplejwt.tokens import RefreshToken


class LoginView(APIView):

    def post(self, request):
        data = JSONParser().parse(request)
        user = authenticate(request, username=data['email'], password=data['password'])

        if user is None:
            res = {
                'success': False,
                'err': 'User Does Not Exist'
            }
            return JsonResponse(res, status=status.HTTP_400_BAD_REQUEST)

        else:
            refresh = RefreshToken.for_user(user)
            refresh_token = str(refresh)
            access_token = str(refresh.access_token)
            login(request, user)

            res_data = {
                'success': True,
                'access': access_token,
                'refresh': refresh_token
            }

            response = JsonResponse(res_data, status=status.HTTP_201_CREATED)
            response.set_cookie('access', access_token, httponly=True)
            response.set_cookie('refresh', access_token, httponly=True)

            return response

