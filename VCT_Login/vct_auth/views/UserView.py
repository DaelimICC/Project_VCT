from django.contrib.sessions.models import Session
from django.http import JsonResponse
from rest_framework import status
from rest_framework.views import APIView
from vct_auth.serializer import SignupUserSerializer
from vct_auth.models import User


class UserView(APIView):

    def post(self, request):
        serializer = SignupUserSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()

            res = {
                'success': True
            }
            return JsonResponse(res, status=status.HTTP_201_CREATED)

        else:
            res = {
                'success': False,
                'err': serializer.errors
            }
            return JsonResponse(res, status=status.HTTP_400_BAD_REQUEST)

    def get(self, request):
        try:
            s = Session.objects.get(pk=request.session.session_key)
            decoded = s.get_decoded()
            user = User.objects.get(id=int(decoded.get('_auth_user_id')))

            res = {
                'email': user.email,
                'nick': user.nick,
                'phone': user.phone
            }
            return JsonResponse(res, status=status.HTTP_200_OK)

        except User.DoesNotExist:
            res = {
                'success': False,
                'err': 'User Does Not Exist'
            }
            return JsonResponse(res, status=status.HTTP_400_BAD_REQUEST)
        except Session.DoesNotExist:
            res = {
                'success:': False,
                'err': 'Session Does Not Exist'
            }
            return JsonResponse(res, status=status.HTTP_400_BAD_REQUEST)
