from django.http import JsonResponse
from rest_framework import status
from rest_framework.views import APIView
from rest_framework.parsers import JSONParser
from django.contrib.auth import authenticate, login


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
            res_data = {
                'success': True
            }
            login(request, user)
            return JsonResponse(res_data, status=status.HTTP_201_CREATED)

