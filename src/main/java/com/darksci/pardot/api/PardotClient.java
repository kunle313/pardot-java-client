/**
 * Copyright 2017, 2018, 2019, 2020 Stephen Powis https://github.com/Crim/pardot-java-client
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.darksci.pardot.api;

import com.darksci.pardot.api.auth.SessionRefreshHandler;
import com.darksci.pardot.api.config.Configuration;
import com.darksci.pardot.api.parser.DeleteResponseParser;
import com.darksci.pardot.api.parser.ErrorResponseParser;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.parser.account.AccountReadResponseParser;
import com.darksci.pardot.api.parser.campaign.CampaignQueryResponseParser;
import com.darksci.pardot.api.parser.campaign.CampaignReadResponseParser;
import com.darksci.pardot.api.parser.customfield.CustomFieldQueryResponseParser;
import com.darksci.pardot.api.parser.customfield.CustomFieldReadResponseParser;
import com.darksci.pardot.api.parser.customredirect.CustomRedirectQueryResponseParser;
import com.darksci.pardot.api.parser.customredirect.CustomRedirectReadResponseParser;
import com.darksci.pardot.api.parser.dynamiccontent.DynamicContentQueryResponseParser;
import com.darksci.pardot.api.parser.dynamiccontent.DynamicContentReadResponseParser;
import com.darksci.pardot.api.parser.email.EmailReadResponseParser;
import com.darksci.pardot.api.parser.email.EmailStatsResponseParser;
import com.darksci.pardot.api.parser.emailclick.EmailClickQueryResponseParser;
import com.darksci.pardot.api.parser.emailtemplate.EmailTemplateListOneToOneResponseParser;
import com.darksci.pardot.api.parser.emailtemplate.EmailTemplateReadResponseParser;
import com.darksci.pardot.api.parser.form.FormQueryResponseParser;
import com.darksci.pardot.api.parser.form.FormReadResponseParser;
import com.darksci.pardot.api.parser.list.ListQueryResponseParser;
import com.darksci.pardot.api.parser.list.ListReadResponseParser;
import com.darksci.pardot.api.parser.listmembership.ListMembershipQueryResponseParser;
import com.darksci.pardot.api.parser.listmembership.ListMembershipReadResponseParser;
import com.darksci.pardot.api.parser.login.LoginResponseParser;
import com.darksci.pardot.api.parser.login.SsoLoginErrorResponseParser;
import com.darksci.pardot.api.parser.login.SsoLoginResponseParser;
import com.darksci.pardot.api.parser.opportunity.OpportunityQueryResponseParser;
import com.darksci.pardot.api.parser.opportunity.OpportunityReadResponseParser;
import com.darksci.pardot.api.parser.prospect.ProspectQueryResponseParser;
import com.darksci.pardot.api.parser.prospect.ProspectReadResponseParser;
import com.darksci.pardot.api.parser.tag.TagQueryResponseParser;
import com.darksci.pardot.api.parser.tag.TagReadResponseParser;
import com.darksci.pardot.api.parser.tagobject.TagObjectQueryResponseParser;
import com.darksci.pardot.api.parser.tagobject.TagObjectReadResponseParser;
import com.darksci.pardot.api.parser.user.UserAbilitiesParser;
import com.darksci.pardot.api.parser.user.UserCookieParser;
import com.darksci.pardot.api.parser.user.UserCreateResponseParser;
import com.darksci.pardot.api.parser.user.UserQueryResponseParser;
import com.darksci.pardot.api.parser.user.UserReadResponseParser;
import com.darksci.pardot.api.parser.visitor.VisitorQueryResponseParser;
import com.darksci.pardot.api.parser.visitor.VisitorReadResponseParser;
import com.darksci.pardot.api.parser.visitoractivity.VisitorActivityQueryResponseParser;
import com.darksci.pardot.api.parser.visitoractivity.VisitorActivityReadResponseParser;
import com.darksci.pardot.api.request.Request;
import com.darksci.pardot.api.request.UserDefinedRequest;
import com.darksci.pardot.api.request.account.AccountReadRequest;
import com.darksci.pardot.api.request.campaign.CampaignCreateRequest;
import com.darksci.pardot.api.request.campaign.CampaignQueryRequest;
import com.darksci.pardot.api.request.campaign.CampaignReadRequest;
import com.darksci.pardot.api.request.campaign.CampaignUpdateRequest;
import com.darksci.pardot.api.request.customfield.CustomFieldCreateRequest;
import com.darksci.pardot.api.request.customfield.CustomFieldDeleteRequest;
import com.darksci.pardot.api.request.customfield.CustomFieldQueryRequest;
import com.darksci.pardot.api.request.customfield.CustomFieldReadRequest;
import com.darksci.pardot.api.request.customfield.CustomFieldUpdateRequest;
import com.darksci.pardot.api.request.customredirect.CustomRedirectQueryRequest;
import com.darksci.pardot.api.request.customredirect.CustomRedirectReadRequest;
import com.darksci.pardot.api.request.dynamiccontent.DynamicContentQueryRequest;
import com.darksci.pardot.api.request.dynamiccontent.DynamicContentReadRequest;
import com.darksci.pardot.api.request.email.EmailReadRequest;
import com.darksci.pardot.api.request.email.EmailSendListRequest;
import com.darksci.pardot.api.request.email.EmailSendOneToOneRequest;
import com.darksci.pardot.api.request.email.EmailStatsRequest;
import com.darksci.pardot.api.request.emailclick.EmailClickQueryRequest;
import com.darksci.pardot.api.request.emailtemplate.EmailTemplateListOneToOneRequest;
import com.darksci.pardot.api.request.emailtemplate.EmailTemplateReadRequest;
import com.darksci.pardot.api.request.form.FormCreateRequest;
import com.darksci.pardot.api.request.form.FormDeleteRequest;
import com.darksci.pardot.api.request.form.FormQueryRequest;
import com.darksci.pardot.api.request.form.FormReadRequest;
import com.darksci.pardot.api.request.form.FormUpdateRequest;
import com.darksci.pardot.api.request.list.ListCreateRequest;
import com.darksci.pardot.api.request.list.ListQueryRequest;
import com.darksci.pardot.api.request.list.ListReadRequest;
import com.darksci.pardot.api.request.list.ListUpdateRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipCreateRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipQueryRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipReadRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipUpdateRequest;
import com.darksci.pardot.api.request.login.LoginRequest;
import com.darksci.pardot.api.request.login.LoginRequestMarker;
import com.darksci.pardot.api.request.login.SsoLoginRequest;
import com.darksci.pardot.api.request.login.SsoRefreshTokenRequest;
import com.darksci.pardot.api.request.opportunity.OpportunityCreateRequest;
import com.darksci.pardot.api.request.opportunity.OpportunityDeleteRequest;
import com.darksci.pardot.api.request.opportunity.OpportunityQueryRequest;
import com.darksci.pardot.api.request.opportunity.OpportunityReadRequest;
import com.darksci.pardot.api.request.opportunity.OpportunityUndeleteRequest;
import com.darksci.pardot.api.request.opportunity.OpportunityUpdateRequest;
import com.darksci.pardot.api.request.prospect.ProspectAssignRequest;
import com.darksci.pardot.api.request.prospect.ProspectCreateRequest;
import com.darksci.pardot.api.request.prospect.ProspectDeleteRequest;
import com.darksci.pardot.api.request.prospect.ProspectQueryRequest;
import com.darksci.pardot.api.request.prospect.ProspectReadRequest;
import com.darksci.pardot.api.request.prospect.ProspectUnassignRequest;
import com.darksci.pardot.api.request.prospect.ProspectUpdateRequest;
import com.darksci.pardot.api.request.prospect.ProspectUpsertRequest;
import com.darksci.pardot.api.request.tag.TagQueryRequest;
import com.darksci.pardot.api.request.tag.TagReadRequest;
import com.darksci.pardot.api.request.tagobject.TagObjectQueryRequest;
import com.darksci.pardot.api.request.tagobject.TagObjectReadRequest;
import com.darksci.pardot.api.request.user.UserAbilitiesRequest;
import com.darksci.pardot.api.request.user.UserCookieRequest;
import com.darksci.pardot.api.request.user.UserCreateRequest;
import com.darksci.pardot.api.request.user.UserDeleteRequest;
import com.darksci.pardot.api.request.user.UserQueryRequest;
import com.darksci.pardot.api.request.user.UserReadRequest;
import com.darksci.pardot.api.request.user.UserUpdateRoleRequest;
import com.darksci.pardot.api.request.visitor.VisitorAssignRequest;
import com.darksci.pardot.api.request.visitor.VisitorQueryRequest;
import com.darksci.pardot.api.request.visitor.VisitorReadRequest;
import com.darksci.pardot.api.request.visitoractivity.VisitorActivityQueryRequest;
import com.darksci.pardot.api.request.visitoractivity.VisitorActivityReadRequest;
import com.darksci.pardot.api.response.ErrorCode;
import com.darksci.pardot.api.response.ErrorResponse;
import com.darksci.pardot.api.response.Result;
import com.darksci.pardot.api.response.account.Account;
import com.darksci.pardot.api.response.campaign.Campaign;
import com.darksci.pardot.api.response.campaign.CampaignQueryResponse;
import com.darksci.pardot.api.response.customfield.CustomField;
import com.darksci.pardot.api.response.customfield.CustomFieldQueryResponse;
import com.darksci.pardot.api.response.customredirect.CustomRedirect;
import com.darksci.pardot.api.response.customredirect.CustomRedirectQueryResponse;
import com.darksci.pardot.api.response.dynamiccontent.DynamicContent;
import com.darksci.pardot.api.response.dynamiccontent.DynamicContentQueryResponse;
import com.darksci.pardot.api.response.email.Email;
import com.darksci.pardot.api.response.email.EmailStatsResponse;
import com.darksci.pardot.api.response.emailclick.EmailClickQueryResponse;
import com.darksci.pardot.api.response.emailtemplate.EmailTemplate;
import com.darksci.pardot.api.response.emailtemplate.EmailTemplateListOneToOneResponse;
import com.darksci.pardot.api.response.form.Form;
import com.darksci.pardot.api.response.form.FormQueryResponse;
import com.darksci.pardot.api.response.list.List;
import com.darksci.pardot.api.response.list.ListMembership;
import com.darksci.pardot.api.response.list.ListQueryResponse;
import com.darksci.pardot.api.response.listmembership.ListMembershipQueryResponse;
import com.darksci.pardot.api.response.login.LoginResponse;
import com.darksci.pardot.api.response.login.SsoLoginErrorResponse;
import com.darksci.pardot.api.response.login.SsoLoginResponse;
import com.darksci.pardot.api.response.opportunity.Opportunity;
import com.darksci.pardot.api.response.opportunity.OpportunityQueryResponse;
import com.darksci.pardot.api.response.prospect.Prospect;
import com.darksci.pardot.api.response.prospect.ProspectQueryResponse;
import com.darksci.pardot.api.response.tag.Tag;
import com.darksci.pardot.api.response.tag.TagQueryResponse;
import com.darksci.pardot.api.response.tagobject.TagObject;
import com.darksci.pardot.api.response.tagobject.TagObjectQueryResponse;
import com.darksci.pardot.api.response.user.Cookie;
import com.darksci.pardot.api.response.user.User;
import com.darksci.pardot.api.response.user.UserAbilitiesResponse;
import com.darksci.pardot.api.response.user.UserQueryResponse;
import com.darksci.pardot.api.response.visitor.Visitor;
import com.darksci.pardot.api.response.visitor.VisitorQueryResponse;
import com.darksci.pardot.api.response.visitoractivity.VisitorActivity;
import com.darksci.pardot.api.response.visitoractivity.VisitorActivityQueryResponse;
import com.darksci.pardot.api.rest.HttpClientRestClient;
import com.darksci.pardot.api.rest.RestClient;
import com.darksci.pardot.api.rest.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * Interface for Pardot's API.
 */
public class PardotClient implements AutoCloseable {
    private static final Logger logger = LoggerFactory.getLogger(PardotClient.class);

    /**
     * Our API Configuration.
     */
    private final Configuration configuration;

    /**
     * Handles renewing an authentication session when it expires.
     */
    private final SessionRefreshHandler sessionRefreshHandler;

    /**
     * Underlying RestClient to use.
     */
    private final RestClient restClient;

    /**
     * Internal State flag.
     */
    private boolean isInitialized = false;

    /**
     * Default Constructor.
     * @param configurationBuilder Pardot Api Configuration Builder instance.
     */
    public PardotClient(final ConfigurationBuilder configurationBuilder) {
        this(
            configurationBuilder,
            new HttpClientRestClient()
        );
    }

    /**
     * Constructor for injecting a RestClient implementation.
     * Typically only used in testing.
     * @param configurationBuilder Pardot Api Configuration Builder instance.
     * @param restClient RestClient implementation to use.
     */
    public PardotClient(final ConfigurationBuilder configurationBuilder, final RestClient restClient) {
        this(
            Objects.requireNonNull(configurationBuilder).build(),
            Objects.requireNonNull(restClient)
        );
    }

    /**
     * Package protected constructor for when you need to keep a reference to the actual
     * configuration instance being used.  Typically for test use cases only.
     *
     * @param configuration Pardot API Configuration instance.
     * @param restClient RestClient implementation to use.
     */
    PardotClient(final Configuration configuration, final RestClient restClient) {
        this.configuration = Objects.requireNonNull(configuration);
        this.restClient = Objects.requireNonNull(restClient);
        this.sessionRefreshHandler = Objects.requireNonNull(configuration.getSessionRefreshHandler());
    }

    private <T> Result<T> submitRequest(final Request request, final ResponseParser<T> responseParser) {
        // Avoid doing login check if we're doing a login request.
        if (!(request instanceof LoginRequestMarker)) {
            // Check for auth token
            checkLogin();
        }

        // Submit request
        final RestResponse restResponse = getRestClient().submitRequest(request);
        final int responseCode = restResponse.getHttpCode();
        String responseStr = restResponse.getResponseStr();

        // Don't log out responses from Login requests to avoid leaking sensitive details.
        if (!(request instanceof LoginRequestMarker)) {
            logger.info("Response: {}", restResponse);
        }

        // Check for invalid http status codes
        if (responseCode >= 200 && responseCode < 300) {
            // These response codes have no values
            if ((responseCode == 204 || responseCode == 205) && responseStr == null) {
                // Avoid NPE
                responseStr = "";
            }
        }

        // High level check for Pardot error responses
        if (responseStr.contains("<rsp stat=\"fail\"")) {
            try {
                // Parse error response
                final ErrorResponse error = new ErrorResponseParser().parseResponse(responseStr);

                // Handle various error codes
                // Session expiration error codes.
                if (ErrorCode.INVALID_API_OR_USER_KEY.getCode() == error.getCode()
                    || ErrorCode.INVALID_ACCESS_TOKEN.getCode() == error.getCode()) {
                    
                    // This means the user session has expired.  Lets attempt to renew it.
                    sessionRefreshHandler.clearToken();
                    checkLogin();

                    // Replay original request
                    return submitRequest(request, responseParser);
                } else if (ErrorCode.WRONG_API_VERSION.getCode() == error.getCode() && ! "4".equals(configuration.getPardotApiVersion())) {
                    // This means we execute a request against api version 3, but the account requires api version 4.
                    // Lets transparently switch to version 4 and re-send the request.
                    logger.info("Detected API version 4 should be used, retrying request with API Version 4.");

                    // Upgrade to version 4.
                    configuration.setPardotApiVersion("4");

                    // Replay original request
                    return submitRequest(request, responseParser);
                }
                // Return error response.
                return Result.newFailure(error);
            } catch (final IOException exception) {
                throw new ParserException(exception.getMessage(), exception);
            }
        }

        // If not a success response code
        if (responseCode < 200 || responseCode >= 300) {
            // Handle SSO Login Failures
            if (request instanceof SsoLoginRequest) {
                // Attempt to parse SSO Error Response.
                try {
                    final SsoLoginErrorResponse errorResponse = new SsoLoginErrorResponseParser().parseResponse(responseStr);
                    throw new LoginFailedException("[" + errorResponse.getError() + "] " + errorResponse.getDescription(), responseCode);
                } catch (final IOException exception) {
                    throw new ParserException(exception.getMessage(), exception);
                }
            }
            // We got an error http response code, but the API didn't return an error response....
            // Not sure this scenario exists, but lets throw an exception.
            throw new InvalidRequestException("Invalid http response code from server: " + restResponse.getHttpCode(), restResponse.getHttpCode());
        }

        // Attempt to parse and return a Success result.
        try {
            return Result.newSuccess(
                responseParser.parseResponse(restResponse.getResponseStr())
            );
        } catch (final IOException exception) {
            throw new ParserException(exception.getMessage(), exception);
        }
    }

    /**
     * Returns the API configuration instance.
     *
     * @return Return Pardot API Configuration.
     */
    Configuration getConfiguration() {
        return configuration;
    }

    /**
     * package protected for access in tests.
     * @return Rest Client.
     */
    RestClient getRestClient() {
        // If we haven't initialized.
        if (!isInitialized) {
            // Call Init.
            restClient.init(getConfiguration());

            // Flip state flag
            isInitialized = true;
        }

        // return our rest client.
        return restClient;
    }

    /**
     * Check to see if we're already logged in and have an API key.
     * If no existing API key is found, this will attempt to authenticate and
     * get a new API key.
     * @throws LoginFailedException if credentials are invalid.
     */
    private void checkLogin() {
        if (sessionRefreshHandler.isValid()) {
            return;
        }

        // refreshCredentials() method should return true if refresh was successful,
        // If it returns false, throw LoginFailedException
        if (!sessionRefreshHandler.refreshCredentials(this)) {
            throw new LoginFailedException(
                "SessionRefreshHandler " + sessionRefreshHandler.getClass().getSimpleName() + " failed to refresh authentication token",
                0
            );
        };
    }

    /**
     * Execute login request using Pardot Username and Password authentication.
     *
     * @param request Login request definition.
     * @return LoginResponse returned from server.
     * @throws LoginFailedException if credentials are invalid.
     * @deprecated Pardot is removing Username and Password authentication, it has been replaced
     *             with SSO authentication. {@link PardotClient#login(SsoLoginRequest)}
     */
    public LoginResponse login(final LoginRequest request) {
        final LoginResponse loginResponse = submitRequest(request, new LoginResponseParser())
            .handleError((errorResponse) -> {
                // If authentication error response
                if (ErrorCode.LOGIN_FAILED.getCode() == errorResponse.getCode()) {
                    // Throw specific login failed exception.
                    throw new LoginFailedException(errorResponse.getMessage(), errorResponse.getCode());
                }
                // Otherwise throw generic exception.
                throw new InvalidRequestException(errorResponse.getMessage(), errorResponse.getCode());
            });

        // If we have a version mis-match.
        if (!loginResponse.getApiVersion().equals(getConfiguration().getPardotApiVersion())) {
            // Log what we're doing
            logger.info(
                "Upgrading API version from {} to {}",
                getConfiguration().getPardotApiVersion(),
                loginResponse.getApiVersion());

            // Update configuration
            getConfiguration().setPardotApiVersion(loginResponse.getApiVersion());
        }
        return loginResponse;
    }

    /**
     * Execute login request using Salesforce SSO authentication.
     *
     * @param request Login request definition.
     * @return SsoLoginResponse returned from server.
     * @throws LoginFailedException if credentials are invalid.
     */
    public SsoLoginResponse login(final SsoLoginRequest request) {
        try {
            return submitRequest(request, new SsoLoginResponseParser()).get();
        } catch (final InvalidRequestException exception) {
            // Rethrow login failed exceptions as-is.
            if (exception instanceof LoginFailedException) {
                throw exception;
            }
            // Otherwise throw a more specific exception
            throw new LoginFailedException(exception.getMessage(), exception.getErrorCode(), exception);
        }
    }

    /**
     * Execute login request using Salesforce SSO authentication.
     *
     * @param request Login request definition.
     * @return SsoLoginResponse returned from server.
     * @throws LoginFailedException if credentials are invalid.
     */
    public SsoLoginResponse login(final SsoRefreshTokenRequest request) {
        try {
            return submitRequest(request, new SsoLoginResponseParser()).get();
        } catch (final InvalidRequestException exception) {
            // Rethrow login failed exceptions as-is.
            if (exception instanceof LoginFailedException) {
                throw exception;
            }
            // Otherwise throw a more specific exception
            throw new LoginFailedException(exception.getMessage(), exception.getErrorCode(), exception);
        }
    }

    /**
     * Make API request to read the account of the currently authenticated user.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Account accountRead(final AccountReadRequest request) {
        return submitRequest(request, new AccountReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to query one or more users.
     * @param request Request definition.
     * @return Parsed user query response.
     */
    public UserQueryResponse.Result userQuery(final UserQueryRequest request) {
        return submitRequest(request, new UserQueryResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read the abilities of the currently authenticated user.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public UserAbilitiesResponse.Result userAbilities(final UserAbilitiesRequest request) {
        return submitRequest(request, new UserAbilitiesParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read the login cookie of the currently authenticated user.
     * @param request Requet definition.
     * @return Parsed api response.
     */
    public Cookie userCookie(final UserCookieRequest request) {
        return submitRequest(request, new UserCookieParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read a specific user.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Optional<User> userRead(final UserReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new UserReadResponseParser()),
            ErrorCode.INVALID_USER_ID
        );
    }

    /**
     * Make API request to delete a specific user.
     * @param request Request definition.
     * @return Result instance containing boolean true if a success, or an ErrorResponse if an error occurred.
     */
    public Result<Boolean> userDelete(final UserDeleteRequest request) {
        return submitRequest(request, new DeleteResponseParser());
    }

    /**
     * Make API request to create a new user.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public User userCreate(final UserCreateRequest request) {
        return submitRequest(request, new UserCreateResponseParser())
            .orElseThrowInvalidRequestException()
            .getUser();
    }

    /**
     * Make API request to update role on a Pardot user.
     * @param request Request definition.
     * @return Parsed api response containing the updated user record.
     */
    public User userUpdateRole(final UserUpdateRoleRequest request) {
        return submitRequest(request, new UserReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to query for one or more campaigns.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public CampaignQueryResponse.Result campaignQuery(final CampaignQueryRequest request) {
        return submitRequest(request, new CampaignQueryResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read a specific campaign.
     * @param request Request definition.
     * @return Optional of Campaign that was selected.
     */
    public Optional<Campaign> campaignRead(final CampaignReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new CampaignReadResponseParser()),
            ErrorCode.INVALID_ID
        );
    }

    /**
     * Make API request to create a new Campaign.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Campaign campaignCreate(final CampaignCreateRequest request) {
        return submitRequest(request, new CampaignReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to update an existing Campaign.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Campaign campaignUpdate(final CampaignUpdateRequest request) {
        return submitRequest(request, new CampaignReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to query for one or more custom fields.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public CustomFieldQueryResponse.Result customFieldQuery(final CustomFieldQueryRequest request) {
        return submitRequest(request, new CustomFieldQueryResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read a specific custom field.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Optional<CustomField> customFieldRead(final CustomFieldReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new CustomFieldReadResponseParser()),
            ErrorCode.INVALID_ID
        );
    }

    /**
     * Make API request to create a new Custom field.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public CustomField customFieldCreate(final CustomFieldCreateRequest request) {
        return submitRequest(request, new CustomFieldReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to update an existing custom field.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public CustomField customFieldUpdate(final CustomFieldUpdateRequest request) {
        return submitRequest(request, new CustomFieldReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to delete a custom field.
     * @param request Request definition.
     * @return Result instance containing boolean true if a success, or an ErrorResponse if an error occurred.
     */
    public Result<Boolean> customFieldDelete(final CustomFieldDeleteRequest request) {
        return submitRequest(request, new DeleteResponseParser());
    }

    /**
     * Make API request to query for one or more custom redirects.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public CustomRedirectQueryResponse.Result customRedirectQuery(final CustomRedirectQueryRequest request) {
        return submitRequest(request, new CustomRedirectQueryResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read a specific custom redirect.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Optional<CustomRedirect> customRedirectRead(final CustomRedirectReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new CustomRedirectReadResponseParser()),
            ErrorCode.INVALID_ID
        );
    }

    /**
     * Make API request to query for one or more dynamic contents.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public DynamicContentQueryResponse.Result dynamicContentQuery(final DynamicContentQueryRequest request) {
        return submitRequest(request, new DynamicContentQueryResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read a specific dynamic content.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Optional<DynamicContent> dynamicContentRead(final DynamicContentReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new DynamicContentReadResponseParser()),
            ErrorCode.INVALID_ID
        );
    }

    /**
     * Make API request to read a specific Email.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Optional<Email> emailRead(final EmailReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new EmailReadResponseParser()),
            ErrorCode.INVALID_ID
        );
    }

    /**
     * Make API request to retrieve stats about a List Email Send.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Optional<EmailStatsResponse.Stats> emailStats(final EmailStatsRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new EmailStatsResponseParser()),
            ErrorCode.INVALID_ID
        );
    }

    /**
     * Make API request to send a 1-to-1 prospect email.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Email emailSendOneToOne(final EmailSendOneToOneRequest request) {
        return submitRequest(request, new EmailReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to send a list email.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Email emailSendList(final EmailSendListRequest request) {
        return submitRequest(request, new EmailReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to query for one or more email clicks.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public EmailClickQueryResponse.Result emailClickQuery(final EmailClickQueryRequest request) {
        return submitRequest(request, new EmailClickQueryResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read a specific Email.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Optional<EmailTemplate> emailTemplateRead(final EmailTemplateReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new EmailTemplateReadResponseParser()),
            ErrorCode.INVALID_ID, ErrorCode.INVALID_EMAIL_TEMPLATE
        );
    }

    /**
     * Make API request to list all one to one email templates.
     * @return Parsed api response.
     */
    public EmailTemplateListOneToOneResponse.Result emailTemplateListOneToOne() {
        return submitRequest(new EmailTemplateListOneToOneRequest(), new EmailTemplateListOneToOneResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to create a new form.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Form formCreate(final FormCreateRequest request) {
        return submitRequest(request, new FormReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to delete a form.
     * @param request Request definition.
     * @return Result instance containing boolean true if a success, or an ErrorResponse if an error occurred.
     */
    public Result<Boolean> formDelete(final FormDeleteRequest request) {
        return submitRequest(request, new DeleteResponseParser());
    }

    /**
     * Make API request to query for one or more forms.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public FormQueryResponse.Result formQuery(final FormQueryRequest request) {
        return submitRequest(request, new FormQueryResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read a specific form.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Optional<Form> formRead(final FormReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new FormReadResponseParser()),
            ErrorCode.INVALID_ID
        );
    }

    /**
     * Make API request to update an existing form.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Form formUpdate(final FormUpdateRequest request) {
        return submitRequest(request, new FormReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to query for one or more lists.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public ListQueryResponse.Result listQuery(final ListQueryRequest request) {
        return submitRequest(request, new ListQueryResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read a specific list.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Optional<List> listRead(final ListReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new ListReadResponseParser()),
            ErrorCode.INVALID_ID
        );
    }

    /**
     * Make API request to create a new List.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public List listCreate(final ListCreateRequest request) {
        return submitRequest(request, new ListReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to update an existing List.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public List listUpdate(final ListUpdateRequest request) {
        return submitRequest(request, new ListReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to query for one or more list memberships.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public ListMembershipQueryResponse.Result listMembershipQuery(final ListMembershipQueryRequest request) {
        return submitRequest(request, new ListMembershipQueryResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read a listMembership.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Optional<ListMembership> listMembershipRead(final ListMembershipReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new ListMembershipReadResponseParser()),
            ErrorCode.INVALID_LIST_ID, ErrorCode.INVALID_ID
        );
    }

    /**
     * Make API request to create a new List Membership.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public ListMembership listMembershipCreate(final ListMembershipCreateRequest request) {
        return submitRequest(request, new ListMembershipReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to update an existing List Membership.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public ListMembership listMembershipUpdate(final ListMembershipUpdateRequest request) {
        return submitRequest(request, new ListMembershipReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to query opportunities.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public OpportunityQueryResponse.Result opportunityQuery(final OpportunityQueryRequest request) {
        return submitRequest(request, new OpportunityQueryResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read an opportunity.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Optional<Opportunity> opportunityRead(final OpportunityReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new OpportunityReadResponseParser()),
            ErrorCode.INVALID_ID, ErrorCode.INVALID_OPPORTUNITY_ID
        );
    }

    /**
     * Make API request to create an opportunity.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Opportunity opportunityCreate(final OpportunityCreateRequest request) {
        return submitRequest(request, new OpportunityReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to update an opportunity.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Opportunity opportunityUpdate(final OpportunityUpdateRequest request) {
        return submitRequest(request, new OpportunityReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to delete an opportunity.
     * @param request Request definition.
     * @return Result instance containing boolean true if a success, or an ErrorResponse if an error occurred.
     */
    public Result<Boolean> opportunityDelete(final OpportunityDeleteRequest request) {
        return submitRequest(request, new DeleteResponseParser());
    }

    /**
     * Make API request to un-delete an opportunity.
     * @param request Request definition.
     * @return Result instance containing boolean true if a success, or an ErrorResponse if an error occurred.
     */
    public Result<Boolean> opportunityUndelete(final OpportunityUndeleteRequest request) {
        return submitRequest(request, new DeleteResponseParser());
    }

    /**
     * Make API request to read a prospect.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Optional<Prospect> prospectRead(final ProspectReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new ProspectReadResponseParser()),
            ErrorCode.INVALID_ID, ErrorCode.INVALID_PROSPECT_ID, ErrorCode.INVALID_PROSPECT_EMAIL_ADDRESS
        );
    }

    /**
     * Make API request to create a new prospect.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Prospect prospectCreate(final ProspectCreateRequest request) {
        return submitRequest(request, new ProspectReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to update an existing prospect.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Prospect prospectUpdate(final ProspectUpdateRequest request) {
        return submitRequest(request, new ProspectReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to upsert a prospect.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Prospect prospectUpsert(final ProspectUpsertRequest request) {
        return submitRequest(request, new ProspectReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to query prospects.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public ProspectQueryResponse.Result prospectQuery(final ProspectQueryRequest request) {
        return submitRequest(request, new ProspectQueryResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to delete prospects.
     * @param request Request definition.
     * @return Result instance containing boolean true if a success, or an ErrorResponse if an error occurred.
     */
    public Result<Boolean> prospectDelete(final ProspectDeleteRequest request) {
        return submitRequest(request, new DeleteResponseParser());
    }

    /**
     * Make API request to assign a prospect.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Prospect prospectAssign(final ProspectAssignRequest request) {
        return submitRequest(request, new ProspectReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to unassign a prospect.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Prospect prospectUnassign(final ProspectUnassignRequest request) {
        return submitRequest(request, new ProspectReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to query for one or more tags.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public TagQueryResponse.Result tagQuery(final TagQueryRequest request) {
        return submitRequest(request, new TagQueryResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read a specific tag.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Optional<Tag> tagRead(final TagReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new TagReadResponseParser()),
            ErrorCode.INVALID_ID
        );
    }

    /**
     * Make API request to query for one or more tagObjects.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public TagObjectQueryResponse.Result tagObjectQuery(final TagObjectQueryRequest request) {
        return submitRequest(request, new TagObjectQueryResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read a specific tagObject.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Optional<TagObject> tagObjectRead(final TagObjectReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new TagObjectReadResponseParser()),
            ErrorCode.INVALID_ID
        );
    }

    /**
     * Make API request to assign a visitor.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Visitor visitorAssign(final VisitorAssignRequest request) {
        return submitRequest(request, new VisitorReadResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to query visitors.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public VisitorQueryResponse.Result visitorQuery(final VisitorQueryRequest request) {
        return submitRequest(request, new VisitorQueryResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read a visitor activity.
     * @param request Request definition.
     * @return Parsed api response
     */
    public Optional<Visitor> visitorRead(final VisitorReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new VisitorReadResponseParser()),
            ErrorCode.INVALID_ID, ErrorCode.INVALID_VISITOR_ID
        );
    }

    /**
     * Make API request to query visitorActivities.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public VisitorActivityQueryResponse.Result visitorActivityQuery(final VisitorActivityQueryRequest request) {
        return submitRequest(request, new VisitorActivityQueryResponseParser())
            .orElseThrowInvalidRequestException();
    }

    /**
     * Make API request to read a visitor activity.
     * @param request Request definition.
     * @return Parsed api response
     */
    public Optional<VisitorActivity> visitorActivityRead(final VisitorActivityReadRequest request) {
        return optionalUnlessErrorCode(
            submitRequest(request, new VisitorActivityReadResponseParser()),
            ErrorCode.INVALID_ID
        );
    }

    /**
     * Entry point for adhoc user defined requests.
     *
     * @param request Defines the request to made against the API.
     * @param <Self> The class type that extends this so we can return the appropriate value.
     * @param <ResponseObject> Parsed return type.
     * @return parsed response.
     */
    public <Self, ResponseObject> Result<ResponseObject> userDefinedRequest(final UserDefinedRequest<Self, ResponseObject> request) {
        return submitRequest(request, request.getResponseParser());
    }

    /**
     * Clean up instance, releasing any resources held internally.
     */
    public void close() {
        getRestClient().close();
    }

    /**
     * Helper method.
     * @param result API result.
     * @param errorCodes Error codes to allow returning an Optional.empty() for.
     * @param <T> Underlying result object.
     * @return Optional unless an error code not passed is given.
     */
    private <T> Optional<T> optionalUnlessErrorCode(final Result<T> result, final ErrorCode ... errorCodes) {
        return Optional.ofNullable(
            result.handleError((errorResponse) -> {
                final boolean matchedErrorCode = Arrays.stream(errorCodes)
                    .anyMatch((errorCode) -> errorCode.getCode() == result.getFailure().getCode());

                if (matchedErrorCode) {
                    return null;
                }
                throw new InvalidRequestException(result.getFailure().getMessage(), result.getFailure().getCode());
            })
        );
    }
}